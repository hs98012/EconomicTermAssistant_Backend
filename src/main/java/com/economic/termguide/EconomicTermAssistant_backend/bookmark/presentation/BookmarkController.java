package com.economic.termguide.EconomicTermAssistant_backend.bookmark.presentation;

import com.economic.termguide.EconomicTermAssistant_backend.bookmark.application.dto.request.BookmarkRequest;
import com.economic.termguide.EconomicTermAssistant_backend.bookmark.application.dto.response.BookmarkResponse;
import com.economic.termguide.EconomicTermAssistant_backend.bookmark.application.service.BookmarkCreateService;
import com.economic.termguide.EconomicTermAssistant_backend.bookmark.application.service.BookmarkGetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkCreateService bookmarkCreateService;
    private final BookmarkGetService bookmarkGetService;

    @PostMapping("/bookmark")
    public void createBookmark(@RequestBody BookmarkRequest.BookmarkCreateRequest bookmarkCreateRequest) {
        bookmarkCreateService.createBookmark(bookmarkCreateRequest);
    }

    @GetMapping("/bookmark/{uuid}")
    public List<BookmarkResponse.BookmarkInfoResponse> getBookmark(@PathVariable String uuid) {
        return bookmarkGetService.getBookmark(uuid);
    }
}
