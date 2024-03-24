import com.mongodb.client.MongoCollection
import com.mongodb.client.model.Filters
import com.mongodb.client.model.Updates
import org.bson.Document
import org.bson.conversions.Bson;

MongoCollection<Document> collection = vars.getObject("postsCollection");

// Define a filter to match documents where lastEditorUserId is null and ownerId is equal to 11
Bson filter = Filters.and(
    Filters.eq("lastEditorUserId", null),
    Filters.eq("ownerUserId", 11),
    Filters.lt("id", 0)
);

// Define an update to set a new value for lastEditorUserId
Bson update = Updates.set("lastEditorUserId", 11);

// Perform update operation
def updateResult = collection.updateMany(filter, update);