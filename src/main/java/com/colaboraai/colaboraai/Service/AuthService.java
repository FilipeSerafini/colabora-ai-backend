package com.colaboraai.colaboraai.Service;

import com.colaboraai.colaboraai.Model.Admin;
import com.colaboraai.colaboraai.config.DatabaseConfig;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;
import com.mongodb.client.model.Filters;

@Service
public class AuthService implements UserDetailsService {

    private static final MongoCollection<Document> adminCollection = DatabaseConfig.getCollection("administrador");

    private Admin documentToAdmin(Document doc) {
        return new Admin(
            doc.getString("name"),
            doc.getString("username"),
            doc.getString("password")
        );
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Document userDoc = adminCollection.find(Filters.eq("username", username)).first();
        if (userDoc == null) {
            throw new UsernameNotFoundException("Usuário não encontrado.");
        }

        Admin admin = documentToAdmin(userDoc);  

        UserBuilder builder = User.withUsername(admin.getUsername());
        builder.password(admin.getPassword());  
        builder.roles("ADMIN");

        return builder.build();
    }
}