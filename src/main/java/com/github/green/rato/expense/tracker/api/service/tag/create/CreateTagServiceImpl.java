package com.github.green.rato.expense.tracker.api.service.tag.create;

import com.github.green.rato.expense.tracker.api.common.Status;
import com.github.green.rato.expense.tracker.api.model.TagDTO;
import com.github.green.rato.expense.tracker.api.repository.TagRepository;
import com.github.green.rato.expensetracker.jooq.tables.pojos.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateTagServiceImpl implements CreateTagService{
    private final TagRepository tagRepository;

    @Override
    public CreateTagOutput serve(CreateTagInput input) {
        TagDTO data = buildData(input);
        Tag tag = tagRepository.save(data);
        return buildResponse(tag);
    }

    private CreateTagOutput buildResponse(Tag tag) {
        return CreateTagOutput.builder()
                .id(tag.id())
                .createdAt(tag.createdDate())
                .build();
    }

    private TagDTO buildData(CreateTagInput input) {
        return TagDTO.builder()
                .name(input.name())
                .status(Status.ACTIVE.getStatus())
                .build();
    }
}
