package org.algosketch.android;

import org.algosketch.android.model.Memo;
import org.algosketch.android.repository.MemoRepository;
import org.algosketch.android.repository.MemoRepositoryImpl;
import org.algosketch.android.service.MemoService;
import org.algosketch.android.service.MemoServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemoServiceTest {
    MemoRepository repository = new MemoRepositoryImpl();
    MemoService memoService = new MemoServiceImpl(repository);

    @Test
    void testGetMemos() {
        memoService.writeMemo("hehe");

        Memo result = memoService.getMemos().get(0);

        Assertions.assertThat(result.getContent()).isEqualTo("hehe");
    }
}
