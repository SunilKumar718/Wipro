package springboot_16;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PostService {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/posts";

    @Autowired
    private RestTemplate restTemplate;

    public Post getPost(int id) {
        return restTemplate.getForObject(BASE_URL + "/" + id, Post.class);
    }

    public Post createPost(Post post) {
        return restTemplate.postForObject(BASE_URL, post, Post.class);
    }

    public void updatePost(int id, Post post) {
        restTemplate.put(BASE_URL + "/" + id, post);
    }

    public void deletePost(int id) {
        restTemplate.delete(BASE_URL + "/" + id);
    }
}
