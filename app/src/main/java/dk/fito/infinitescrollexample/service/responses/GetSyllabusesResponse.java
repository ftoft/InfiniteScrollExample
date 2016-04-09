package dk.fito.infinitescrollexample.service.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetSyllabusesResponse {
    private List<Document> docs;
    private int total;
    private String limit;
    private int offset;

    public List<Document> getDocs() {
        return docs;
    }

    public int getTotal() {
        return total;
    }

    public String getLimit() {
        return limit;
    }

    public int getOffset() {
        return offset;
    }

    public class Document {
        @SerializedName("_id")
        private String id;
        private int year;
        private String title;
        private String lecturer;

        public String getId() {
            return id;
        }

        public int getYear() {
            return year;
        }

        public String getTitle() {
            return title;
        }

        public String getLecturer() {
            return lecturer;
        }
    }
}
