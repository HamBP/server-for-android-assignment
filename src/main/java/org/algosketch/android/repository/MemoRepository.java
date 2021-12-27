package org.algosketch.android.repository;

import org.algosketch.android.model.Memo;

import java.util.List;
import java.util.Optional;

public interface MemoRepository {
    List<Memo> getMemoAll();
    Optional<Memo> insertMemo(String content);
    Optional<Memo> findById(Long id);
    Optional<Memo> deleteById(Long id);
}
