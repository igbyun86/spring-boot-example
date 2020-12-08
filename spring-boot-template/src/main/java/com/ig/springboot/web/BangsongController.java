package com.ig.springboot.web;

import com.ig.springboot.model.Bangsong;
import com.ig.springboot.model.BangsongResource;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
public class BangsongController {

    @GetMapping("/{id}")
    public Bangsong getBangsong(@PathVariable Integer id) {
        Bangsong bangsong = new Bangsong();
        bangsong.setId(id);

        return bangsong;
    }

    /**
     * 방법1
     * PropertyEditor사용
     * (단점은 쓰레드 safe하지 않다)
     *
     * 방법2
     * conver 사용(추천)
     *
     * @param bangsong
     * @return
     */
    @GetMapping("/bs/{id}")
    public Bangsong getBangsong(@PathVariable("id") Bangsong bangsong) {
        if (bangsong.getId() == 100) {
            throw new BansongException();
        }

        return bangsong;
    }

    @GetMapping("/bs/h/{id}")
    public BangsongResource BangsongResource(@PathVariable("id") Bangsong bangsong) {

        BangsongResource resource = new BangsongResource(bangsong.getId() + " 번째 방송 중입니다.");

        //resource.add(new Link("http://localhost/bs/h/" + bangsong.getId()));

        Link link = linkTo(BangsongController.class)
                            .slash("bs")
                            .slash("h")
                            .slash(bangsong.getId())
                            .withSelfRel();
        resource.add(link);

        // url은 바뀔수 있으니 bangsongList의 변수명으로 사용하도록 추가
        Link listLink = linkTo(BangsongController.class)
                                .slash("bs")
                                .slash("h")
                                .withRel("bangsongList");
        resource.add(listLink);

        // {"title":"123 번째 방송 중입니다.","_links":{"self":{"href":"http://localhost:8080/bs/h/123"}}}
        // {"title":"123 번째 방송 중입니다.","_links":{"self":{"href":"http://localhost:8080/bs/h/123"},"bangsongList":{"href":"http://localhost:8080/bs/h"}}}

        return resource;
    }

    /**
     * 해당 controller에서만 동작한다.
     * @param e
     * @return
     */
    /*
    @ExceptionHandler(BansongException.class)
    public ResponseEntity<String> handlerException(BansongException e) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }
     */
}
