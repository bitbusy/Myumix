package model;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

import org.bson.types.ObjectId;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.GridFSDownloadStream;

public class TryDown {

	public static void main(String[] args) {
       
        MongoDatabase mongoDatabase = MongoConnect.connect();
        GridFSBucket gridFSBucket = GridFSBuckets.create(mongoDatabase,"tunes");
        ObjectId fileId = new ObjectId("58223be5ae1ae13c6dc78222");
        GridFSDownloadStream downloadStream = gridFSBucket.openDownloadStream(fileId);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        int data = downloadStream.read();
        while (data >= 0) {
            outputStream.write((char) data);
            data = downloadStream.read();
        }
        byte[] bytesToWriteTo = outputStream.toByteArray();
        downloadStream.close();
        System.out.println(new String(bytesToWriteTo, StandardCharsets.UTF_8));
    }
}

