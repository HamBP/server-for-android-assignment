package org.algosketch.android.controller;

import org.algosketch.android.model.Memo;
import org.algosketch.android.service.MemoService;
import org.algosketch.android.service.MemoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MemoController {
    @Autowired
    MemoService memoService;

    @GetMapping("memo")
    @ResponseBody
    public List<Memo> getMemos() {
        return memoService.getMemos();
    }

    @PostMapping("memo")
    @ResponseBody
    public ResponseEntity<Memo> writeMemo(@RequestParam String content) {
        Optional<Memo> result = memoService.writeMemo(content);
        return result.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
