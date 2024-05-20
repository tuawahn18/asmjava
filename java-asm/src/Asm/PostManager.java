package Asm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class PostManager{
    private ArrayList<Post> posts = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

//1. Thêm mới bài viết
public void add(){
    System.out.println("Please, enter new post:");
    System.out.println("Enter post ID: ");
    Integer id = sc.nextInt();
    sc.nextLine();
    System.out.println("Enter post title: ");
    String title = sc.nextLine();
    System.out.println("Enter post describe: ");
    String describe = sc.nextLine();
    System.out.println("Enter post img: ");
    String img = sc.nextLine();
    System.out.println("Enter post content: ");
    String content = sc.nextLine();
    System.out.println("Enter post author: ");
    String author = sc.nextLine();
    System.out.println("Enter post date: ");
    String date = sc.nextLine();

    Post post = new Post(id, title, describe, img, content, author, date);

    posts.add(post);
    System.out.println("Post added");
}

//2. Hiển thị danh sách bài viết vừa nhập
public void show(){
    System.out.println("Show list post");
    System.out.println("-----------------------------------------------------------------------------------------------------------");
    System.out.printf("%-10s || %-10s || %-10s || %-10s || %-10s || %-10s || %-10s\n", "Id", "Title", "Describe", "Image", "Content", "Author", "Date");
    System.out.println("-----------------------------------------------------------------------------------------------------------");
    if (posts.isEmpty()){
        System.out.println("Nothing to show");
    }else{
        Collections.sort(posts, new Comparator<Post>(){
        @Override
        public int compare(Post o1, Post o2) {
            return (int) o1.getId() - o2.getId();
        }
    });
        for(int i = 0 ; i < posts.size() ; i++){
            Post p = posts.get(i);
            System.out.printf("%-10s || %-10s || %-10s || %-10s || %-10s || %-10s || %-10s\n", p.getId(), p.getTitle(), p.getDescribe(), p.getImg(), p.getContent(), p.getAuthor(), p.getDate());
        }
    }
}

//3. Tìm kiếm bài viết theo mã id
public void search(){
    System.out.println("Enter post ID that you want to search:");
    Integer id = sc.nextInt();
    sc.nextLine();

    if (posts.isEmpty()){
        System.out.println("Nothing to show");
    }else{
        Collections.sort(posts, new Comparator<Post>(){
            @Override
            public int compare(Post o1, Post o2) {
                return (int) o1.getId() - o2.getId();
            }
        });
        for(int i = 0 ; i < posts.size() ; i++){
        }
    }

    int l = 0, r = posts.size() - 1;
    while (l <= r) {
        int m = (l + r) / 2;
        if (id.equals(posts.get(m).getId())) {
            System.out.println("Post found: " + posts.get(m));
            return; // Kết thúc phương thức khi tìm thấy bài viết
        } else if (id < posts.get(m).getId()) {
            r = m - 1;
        } else {
            l = m + 1;
        }
    }

    // Thông báo nếu không tìm thấy bài viết
    System.out.println("No post found with the given ID.");
}


//4. Xoá bài viết theo mã id
public void remove() {
    System.out.println("Enter post ID that you want to delete:");
    Integer id = sc.nextInt();
    sc.nextLine();

    if (posts.isEmpty()) {
        System.out.println("No posts to delete.");
        return;
    }

    int l = 0, r = posts.size() - 1;
    boolean found = false;
    int indexToRemove = -1;

    // Sử dụng thuật toán tìm kiếm nhị phân để tìm bài viết
    while (l <= r) {
        int m = (l + r) / 2;
        if (id.equals(posts.get(m).getId())) {
            found = true;
            indexToRemove = m;
            break; // Kết thúc vòng lặp khi tìm thấy bài viết
        } else if (id < posts.get(m).getId()) {
            r = m - 1;
        } else {
            l = m + 1;
        }
    }

    if (found) {
        // Hiển thị thông tin bài viết cần xoá
        System.out.println("Post found: " + posts.get(indexToRemove));

        // Yêu cầu người dùng xác nhận
        System.out.println("Are you sure you want to delete this post? (y/n)");
        String confirm = sc.nextLine();

        if (confirm.equalsIgnoreCase("y")) {
            posts.remove(indexToRemove); // Xoá bài viết tại vị trí indexToRemove
            System.out.println("Post deleted successfully!");
        } else {
            System.out.println("Delete operation cancelled.");
        }
    } else {
        System.out.println("Post with ID " + id + " does not exist.");
    }
}

}
