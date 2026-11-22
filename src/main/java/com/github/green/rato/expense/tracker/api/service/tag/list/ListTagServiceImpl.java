package com.github.green.rato.expense.tracker.api.service.tag.list;

import com.github.green.rato.expense.tracker.api.repository.TagRepository;
import com.github.green.rato.expensetracker.jooq.tables.pojos.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ListTagServiceImpl implements ListTagService{

    private final TagRepository tagRepository;

    @Override
    public List<ListTagOutput> getPage(Integer page, Integer size) {
        List<Tag> data = tagRepository.findAll(page, size);
        return buildResponse(data);
    }

    private List<ListTagOutput> buildResponse(List<Tag> data) {
        return data.stream()
                .map(this::convertToOutput)
                .collect(Collectors.toList());
    }

    private ListTagOutput convertToOutput(Tag tag) {
        return ListTagOutput.builder()
                .id(tag.id())
                .name(tag.name())
                .status(tag.status())
                .createdAt(tag.createdDate())
                .updatedAt(tag.updatedDate())
                .build();
    }
}
