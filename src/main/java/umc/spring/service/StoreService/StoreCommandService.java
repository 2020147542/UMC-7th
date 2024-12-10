package umc.spring.service.StoreService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;

public interface StoreCommandService {

    Page<Review> getReviewList(Long storeId, Integer pageNum);
}