package com.github.green.rato.expense.tracker.api.service.tag.list;

import java.util.List;

public interface ListTagService {
    List<ListTagOutput> getPage(Integer page, Integer size);
}
