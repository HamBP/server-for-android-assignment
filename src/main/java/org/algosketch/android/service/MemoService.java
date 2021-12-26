package org.algosketch.android.service;

import org.algosketch.android.model.Memo;
import org.algosketch.android.repository.MemoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public interface MemoService {
    List<Memo> getMemos();
    Optional<Memo> writeMemo(String content);
};
