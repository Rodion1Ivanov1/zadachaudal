package stack.overflow.backend.controller.advice;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import stack.overflow.backend.service.TagService;

import javax.persistence.EntityNotFoundException;

@RestController("/api/v1/moderator/tags")
public class ModeratorTagRestController {

    private final TagService tagService;

    public ModeratorTagRestController(TagService tagService) {
        this.tagService = tagService;
    }


    @DeleteMapping(value = "/{tagId}")
    public ResponseEntity<Void> delete(@PathVariable("tagId") Integer tagId) throws EntityNotFoundException {
        if (tagService.delete(tagId)) {
            return new ResponseEntity<Void>(HttpStatus.OK);
        } throw new EntityNotFoundException();
    }

}