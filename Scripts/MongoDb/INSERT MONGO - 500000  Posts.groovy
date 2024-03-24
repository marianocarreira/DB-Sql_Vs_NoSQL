import com.mongodb.client.MongoCollection
import org.bson.Document
import org.bson.types.ObjectId
import java.util.concurrent.ThreadLocalRandom

MongoCollection<Document> collection = vars.getObject("postsCollection");

// Generate and insert random data into MongoDB
def generateRandomDate() {
    def offset = ThreadLocalRandom.current().nextLong(946684800000, System.currentTimeMillis())
    return new Date(offset)
}

int rowCount = 500000

for (int i = 0; i < rowCount; i++) {
    def document = new Document([
        "_id": new ObjectId(),
        "id": -(ThreadLocalRandom.current().nextInt(1000000, 9999999)),
        "acceptedAnswerId": 0,
        "answerCount": 0,
        "body": "",
        "closedDate": null,
        "commentCount": 0,
        "communityOwnedDate": null,
        "creationDate": generateRandomDate(),
        "favoriteCount": 0,
        "lastActivityDate": generateRandomDate(),
        "lastEditDate": generateRandomDate(),
        "lastEditorDisplayName": null,
        "lastEditorUserId": null,
        "ownerUserId": 11,
        "parentId": 0,
        "postTypeId": 3,
        "score": ThreadLocalRandom.current().nextInt(0, 100),
        "tags": null,
        "title": null,
        "viewCount": 0,
        "postType": new Document([
            "id": 3,
            "type": "Wiki"
        ]),
        "user": new Document([
            "aboutMe": "<p>Hi, I'm not really a person.</p>",
            "accountId": -1,
            "age": null,
            "creationDate": generateRandomDate(),
            "displayName": "Community",
            "downVotes": ThreadLocalRandom.current().nextInt(0, 1000000),
            "emailHash": null,
            "id": -1,
            "lastAccessDate": generateRandomDate(),
            "location": "on the server farm",
            "reputation": ThreadLocalRandom.current().nextInt(0, 1000000),
            "upVotes": ThreadLocalRandom.current().nextInt(0, 1000000),
            "views": ThreadLocalRandom.current().nextInt(0, 1000000),
            "websiteUrl": "http://meta.stackexchange.com/"
        ])
    ])

    collection.insertOne(document)
}
