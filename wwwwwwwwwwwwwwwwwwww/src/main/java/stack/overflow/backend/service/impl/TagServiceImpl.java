package stack.overflow.backend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stack.overflow.backend.model.entity.Tag;
import stack.overflow.backend.repository.TagRepository;
import stack.overflow.backend.service.TagService;



@RequiredArgsConstructor
@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Transactional
    @Override
    public boolean delete(Integer id) {
        if (tagRepository.findById(id).isPresent()) {
            tagRepository.deleteById(id);
            return true;
        }
        return false;
    }



}
