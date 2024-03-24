import com.mongodb.client.MongoCollection;
import org.bson.Document;

MongoCollection<Document> collection = vars.getObject("postsCollection");

long totalItems = collection.count();

return totalItems;