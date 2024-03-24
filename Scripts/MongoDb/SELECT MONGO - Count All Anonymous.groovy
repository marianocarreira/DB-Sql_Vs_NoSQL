import com.mongodb.client.MongoCollection;
import org.bson.Document;

Document filter = new Document("ownerUserId", 11);
MongoCollection<Document> collection = vars.getObject("postsCollection");
long totalDocuments = collection.count(filter);
return totalDocuments;