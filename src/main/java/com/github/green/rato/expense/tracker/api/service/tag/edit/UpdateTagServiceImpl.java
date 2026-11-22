package com.github.green.rato.expense.tracker.api.service.tag.edit;

import com.github.green.rato.expense.tracker.api.model.TagDTO;
import com.github.green.rato.expense.tracker.api.repository.TagRepository;
import com.github.green.rato.expensetracker.jooq.tables.pojos.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UpdateTagServiceImpl implements UpdateTagService{

    private final TagRepository tagRepository;

    @Override
    public UpdateTagOutput serve(UUID id, UpdateTagInput input) {
        tagRepository.findById(id).orElseThrow(() -> new RuntimeException("Tag not found"));
        TagDTO builtData = buildData(input);
        Tag updatedData = tagRepository.update(id, builtData);
        return buildResponse(updatedData);
    }

    private UpdateTagOutput buildResponse(Tag data) {
        return UpdateTagOutput.builder()
                .id(data.id())
                .createdAt(data.createdDate())
                .updatedAt(data.updatedDate())
                .build();
    }

    @Override
    public UpdateTagOutput delete(UUID id) {
        //TODO Implement Delete
//        UpdateTagInput request = buildDeleteRequest(id, data);
//        return serve();
        return null;
    }

    private TagDTO buildData(UpdateTagInput input) {
        return TagDTO.builder()
                .name(input.name())
                .status(input.status())
                .build();
    }
}
