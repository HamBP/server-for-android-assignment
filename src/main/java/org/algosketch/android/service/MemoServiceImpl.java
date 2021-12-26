package org.algosketch.android.service;

import org.algosketch.android.model.Memo;
import org.algosketch.android.repository.MemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemoServiceImpl implements MemoService {
    MemoRepository repository;

    @Autowired
    public MemoServiceImpl(MemoRepository repository) {
        this.repository = repository;
    }

    public List<Memo> getMemos() {
        return repository.getMemoAll();
    }

    public Optional<Memo> writeMemo(String content) {
        return repository.insertMemo(content);
    }
}
