package org.algosketch.android;

import org.algosketch.android.model.Memo;
import org.algosketch.android.repository.MemoRepository;
import org.algosketch.android.repository.MemoRepositoryImpl;
import org.algosketch.android.service.MemoService;
import org.algosketch.android.service.MemoServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemoServiceTest {
    MemoRepositoryImpl repository = new MemoRepositoryImpl();
    MemoService memoService = new MemoServiceImpl(repository);

    @BeforeEach
    void clearStore() {
        repository.clearAll();
    }

    @Test
    void testGetMemos() {
        memoService.writeMemo("hehe");

        Memo result = memoService.getMemos().get(0);

        Assertions.assertThat(result.getContent()).isEqualTo("hehe");
    }

    @Test
    void findMemo() {
        memoService.writeMemo("hehe");

        Memo result = memoService.findMemo(1L).get();

        Assertions.assertThat(result.getContent()).isEqualTo("hehe");
    }

    @Test
    void deleteMemo() {
        memoService.writeMemo("hehe");

        Memo result = memoService.deleteMemo(1L).get();

        Assertions.assertThat(result.getContent()).isEqualTo("hehe");
    }

    @Test
    void updateMemo() {
        memoService.writeMemo("hehe");

        Memo result = memoService.updateMemo(1L, Memo.PROGRESS).get();

        Assertions.assertThat(result.getContent()).isEqualTo("hehe");
        Assertions.assertThat(result.getStatus()).isEqualTo("PROGRESS");
    }
}
