package umc.spring.service.MemberMissionService;

import umc.spring.domain.enums.MemberStatus;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;

import java.util.List;

public interface MemberMissionQueryService {

    List<MemberMission> findMemberMissions(Long memberId, MissionStatus missionStatus);
}
