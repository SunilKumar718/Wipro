package springboot_16;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class postController{

    @Autowired
    private PostService postService;

    @GetMapping("/{id}")
    public Post getPost(@PathVariable int id){
        return postService.getPost(id);
    }

    @PostMapping
    public Post createPost(@RequestBody Post post){
        return postService.createPost(post);
    }

    @PutMapping("/{id}")
    public String updatePost(@PathVariable int id, @RequestBody Post post) {
        postService.updatePost(id, post);
        return "Post updated!";
    }

    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable int id) {
        postService.deletePost(id);
        return "Post deleted!";
    }
}


