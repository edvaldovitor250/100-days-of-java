import java.util.ArrayList;
import java.util.List;

public class Day090 {

    static class Post {
        
        String image;
        String description;
        List<String> comments;

        public Post(String image, String description) {
            this.image = image;
            this.description = description;
            this.comments = new ArrayList<>();
        }

        public void editPost(String newImage, String newDescription) {
            this.image = newImage;
            this.description = newDescription;
        }

        public void addComment(String comment) {
            this.comments.add(comment);
        }

        public void deleteComment(int index) {
            if (index >= 0 && index < comments.size()) {
                comments.remove(index);
            } else {
                System.out.println("Invalid comment index");
            }
        }

        @Override
        public String toString() {
            return "Image: " + image + "\nDescription: " + description + "\nComments: " + comments;
        }
    }

    static class Blog {
        List<Post> posts;

        public Blog() {
            this.posts = new ArrayList<>();
        }

        public void addPost(String image, String description) {
            posts.add(new Post(image, description));
        }

        public void editPost(int index, String newImage, String newDescription) {
            if (index >= 0 && index < posts.size()) {
                posts.get(index).editPost(newImage, newDescription);
            } else {
                System.out.println("Invalid post index");
            }
        }

        public void deletePost(int index) {
            if (index >= 0 && index < posts.size()) {
                posts.remove(index);
            } else {
                System.out.println("Invalid post index");
            }
        }

        public void addCommentToPost(int postIndex, String comment) {
            if (postIndex >= 0 && postIndex < posts.size()) {
                posts.get(postIndex).addComment(comment);
            } else {
                System.out.println("Invalid post index");
            }
        }

        public void deleteCommentFromPost(int postIndex, int commentIndex) {
            if (postIndex >= 0 && postIndex < posts.size()) {
                posts.get(postIndex).deleteComment(commentIndex);
            } else {
                System.out.println("Invalid post index");
            }
        }

        public void displayPosts() {
            for (int i = 0; i < posts.size(); i++) {
                System.out.println("Post #" + (i + 1) + "\n" + posts.get(i) + "\n");
            }
        }
    }

    public static void main(String[] args) {
        Blog blog = new Blog();

        blog.addPost("image1.jpg", "This is the first post.");
        blog.addPost("image2.jpg", "This is the second post.");

        blog.addCommentToPost(0, "Great post!");
        blog.addCommentToPost(1, "Nice picture!");

        blog.editPost(0, "newImage1.jpg", "Updated first post description.");

        blog.displayPosts();

        blog.deleteCommentFromPost(0, 0);
        blog.deletePost(1);

        blog.displayPosts();
    }
}
