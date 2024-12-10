package umc.spring.service.StoreService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;

public interface StoreCommandService {

    Page<Review> getReviewList(Long storeId, Integer pageNum);
    Page<Review> getUserReviewList(Long userId, Integer pageNum);
    Page<Mission> getStoreMissionList(Long storeId, Integer pageNum);
}
