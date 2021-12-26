package org.algosketch.android.repository;

import org.algosketch.android.model.Memo;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoRepositoryImpl implements MemoRepository {
    Map store = new HashMap<Long, Memo>();
    Long sequence = 0L;

    public List<Memo> getMemoAll() {
        return new ArrayList<Memo>(store.values());
    }

    public Optional<Memo> insertMemo(String content) {
        Memo memo = new Memo(content, 0);
        store.put(++sequence, memo);

        return Optional.of(memo);
    }
}
