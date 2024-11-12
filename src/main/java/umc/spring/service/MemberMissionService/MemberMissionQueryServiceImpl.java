package umc.spring.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository.MemberMissionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public List<MemberMission> findMemberMissions(Long memberId, MissionStatus missionStatus){
        List<MemberMission> filteredMemberMissions = memberMissionRepository.dynamicQueryWithStatus(memberId, missionStatus);
        filteredMemberMissions.forEach(memberMission -> System.out.println("MemberMission: "+ memberMission));

        return filteredMemberMissions;
    }
}
