package org.algosketch.android.controller;

import io.swagger.annotations.Api;
import org.algosketch.android.model.Memo;
import org.algosketch.android.service.MemoService;
import org.algosketch.android.service.MemoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MemoController {
    @Autowired
    MemoService memoService;

    @GetMapping("memo")
    @ResponseBody
    public List<Memo> getMemos() {
        return memoService.getMemos();
    }

    @GetMapping("memo/{id}")
    @ResponseBody
    public ResponseEntity<Memo> findMemo(@PathVariable Long id) {
        Optional<Memo> result = memoService.findMemo(id);
        return result.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("memo")
    @ResponseBody
    public ResponseEntity<Memo> writeMemo(@RequestParam String content) {
        Optional<Memo> result = memoService.writeMemo(content);
        return result.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("memo/{id}")
    @ResponseBody
    public ResponseEntity<Memo> deleteMemo(@PathVariable Long id) {
        Optional<Memo> result = memoService.deleteMemo(id);
        return result.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PatchMapping("memo/{id}")
    @ResponseBody
    public ResponseEntity<Memo> updateMemo(@PathVariable Long id, @RequestParam String status) {
        Optional<Memo> result = memoService.updateMemo(id, status);
        return result.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
