package org.algosketch.android.repository;

import org.algosketch.android.model.Memo;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoRepositoryImpl implements MemoRepository {
    Map<Long, Memo> store = new HashMap<Long, Memo>();
    Long sequence = 0L;

    @Override
    public List<Memo> getMemoAll() {
        return new ArrayList<Memo>(store.values());
    }

    @Override
    public Optional<Memo> insertMemo(String content) {
        Memo memo = new Memo(content, Memo.BEFORE);
        memo.setId(++sequence);
        store.put(memo.getId(), memo);

        return Optional.of(memo);
    }

    @Override
    public Optional<Memo> findById(Long id) {
        return Optional.of(store.get(id));
    }

    @Override
    public Optional<Memo> deleteById(Long id) {
        Optional<Memo> deletedMemo = Optional.of(store.get(id));
        store.remove(id);

        return deletedMemo;
    }

    public void clearAll() {
        store.clear();
    }

    @Override
    public Optional<Memo> updateStatusById(Long id, String status) {
        Optional<Memo> updatedMemo = Optional.of(store.get(id));
        updatedMemo.ifPresent( memo -> memo.setStatus(status) );
        return updatedMemo;
    }
}
