package com.colaboraai.colaboraai.Service;

import java.util.ArrayList;
import org.bson.Document;
import org.springframework.stereotype.Service;
import com.colaboraai.colaboraai.Mapper.PostMapper;
import com.colaboraai.colaboraai.Model.Post;
import com.colaboraai.colaboraai.config.DatabaseConfig;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;

@Service
public class PostService {
    private static final MongoCollection<Document> postCollection = DatabaseConfig.getCollection("postagem");
    private final PostMapper postMapper;

    public PostService() {
        this.postMapper = new PostMapper();
    }

    public ArrayList<Post> getPostsByCategory(String category) {
        ArrayList<Post> postList = new ArrayList<>();

        try (MongoCursor<Document> cursor = postCollection.find(Filters.eq("categoria", category)).iterator()) {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                postList.add(postMapper.documentToPost(doc));
            }
        }

        return postList;
    }

    public ArrayList<Post> getAllPosts() {
        ArrayList<Post> postList = new ArrayList<>();

        try (MongoCursor<Document> cursor = postCollection.find().iterator()) {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                postList.add(postMapper.documentToPost(doc));
            }
        }

        return postList;
    }

    public void createPost(Post post) {
        if (postCollection != null) {
            Document document = new Document(); 
    

            document.put("title", post.getTitle());
            document.put("description", post.getDescription());
            document.put("category", post.getCategory());
            if (post.getFeedback() != null) {
                Document feedbackDocument = new Document();
                document.put("feedback", feedbackDocument);
            }
            document.put("isActive", true);
            
    

            if (post.getPointOfInterest() != null) {
                document.put("pointOfInterest", new Document("titulo", post.getPointOfInterest().getTitulo())
                        .append("latitude", post.getPointOfInterest().getLatitude())
                        .append("longitude", post.getPointOfInterest().getLongitude()));
            }
    

            if (post.getImage() != null && !post.getImage().isEmpty()) {
                document.put("image", post.getImage());
            }
    

            postCollection.insertOne(document);
        } else {
            throw new RuntimeException("Erro ao acessar a coleção de posts.");
        }
    }
    
}