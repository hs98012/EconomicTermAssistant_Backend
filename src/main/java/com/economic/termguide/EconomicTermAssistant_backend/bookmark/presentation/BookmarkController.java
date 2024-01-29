package com.economic.termguide.EconomicTermAssistant_backend.bookmark.presentation;

import com.economic.termguide.EconomicTermAssistant_backend.bookmark.application.dto.request.BookmarkRequest;
import com.economic.termguide.EconomicTermAssistant_backend.bookmark.application.dto.response.BookmarkResponse;
import com.economic.termguide.EconomicTermAssistant_backend.bookmark.application.service.BookmarkCreateService;
import com.economic.termguide.EconomicTermAssistant_backend.bookmark.application.service.BookmarkGetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkCreateService bookmarkCreateService;
    private final BookmarkGetService bookmarkGetService;

    @Operation(summary = "북마크 생성", tags = {"BookmarkController"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "북마크 생성 성공"),
            @ApiResponse(responseCode = "404", description = "북마크 생성 실패")
    })
    @PostMapping("/bookmark")
    public void createBookmark(@RequestBody BookmarkRequest.BookmarkCreateRequest bookmarkCreateRequest) {
        bookmarkCreateService.createBookmark(bookmarkCreateRequest);
    }

    @Operation(summary = "북마크 조회", tags = {"BookmarkController"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "북마크 조회 성공"),
            @ApiResponse(responseCode = "404", description = "북마크 조회 실패")
    })
    @GetMapping("/bookmark/{uuid}")
    public List<BookmarkResponse.BookmarkInfoResponse> getBookmark(@PathVariable String uuid) {
        return bookmarkGetService.getBookmark(uuid);
    }
}
