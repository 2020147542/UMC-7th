package umc.spring.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.ReviewRepository;
import umc.spring.repository.StoreRepository.StoreRepository;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService{

    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    @Override
    public Page<Review> getReviewList(Long storeId, Integer pageNum) {

        Store store = storeRepository.findById(storeId).get();
        return reviewRepository.findAllByStore(store, PageRequest.of(pageNum, 10));
    }

    @Override
    public Page<Review> getUserReviewList(Long userId, Integer pageNum){

        Member member = memberRepository.findById(userId).get();
        return reviewRepository.findAllByMember(member, PageRequest.of(pageNum, 10));
    }

    @Override
    public Page<Mission> getStoreMissionList(Long storeId, Integer pageNum){

        Store store = storeRepository.findById(storeId).get();
        return missionRepository.findAllByStore(store, PageRequest.of(pageNum, 10));
    }
}
