package umc.spring.repository.MemberMissionRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.domain.mapping.QMemberMission;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberMissionRepositoryImpl implements MemberMissionRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QMemberMission memberMission = QMemberMission.memberMission;

    @Override
    public List<MemberMission> dynamicQueryWithStatus(Long memberId, MissionStatus missionStatus){
        BooleanBuilder predicate = new BooleanBuilder();

        if(memberId != null){
            predicate.and(memberMission.member.id.eq(memberId));
        }

        if(missionStatus != null){
            predicate.and(memberMission.missionStatus.eq(missionStatus));
        }

        return jpaQueryFactory
                .selectFrom(memberMission)
                .where(predicate)
                .fetch();
    }
}
