package com.colaboraai.colaboraai.Mapper;

import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import com.colaboraai.colaboraai.Model.PointOfInterest;
import com.colaboraai.colaboraai.Model.Post;

public class PostMapper {

    @SuppressWarnings("unchecked")
    public Post documentToPost(Document doc) {
        String id = doc.getObjectId("_id").toString();
        String title = doc.getString("titulo");
        String description = doc.getString("descricao");
        String image = doc.getString("imagem");

        Object categoryField = doc.get("categoria");
        List<String> categories = new ArrayList<>();
        if (categoryField instanceof List) {
            categories.addAll((List<String>) categoryField);
        } else if (categoryField instanceof String) {
            categories.add((String) categoryField);
        }

        Document pointDocument = (Document) doc.get("ponto_interesse");
        PointOfInterest pointOfInterest = null;
        if (pointDocument != null) {
            pointOfInterest = new PointOfInterest(
                    pointDocument.getObjectId("_id").toString(),
                    pointDocument.getString("titulo"),
                    pointDocument.getString("latitude"),
                    pointDocument.getString("longitude"));
        }
        return new Post(id, title, description, image, categories, pointOfInterest);
    }
}