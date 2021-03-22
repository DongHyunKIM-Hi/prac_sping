package com.sparta.week3.controller;

import com.sparta.week3.domain.Memo;
import com.sparta.week3.domain.MemoRepository;
import com.sparta.week3.domain.MemoRequestDto;
import com.sparta.week3.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class Memocontroller {
    private final MemoRepository memoRepository;
    private final MemoService memoService;

    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto){
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }
    @GetMapping("/api/memos")
    public List<Memo> readMemo(){
        return memoRepository.findAllByOrderByModifiedAtDesc();
    }

    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long  id){
        memoRepository.deleteById(id);
        return id;
    }
    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id , @RequestBody MemoRequestDto requestDto){
        memoService.update(id, requestDto);
        return id;
    }
}
