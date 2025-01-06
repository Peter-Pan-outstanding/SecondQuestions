package wtc.carbon.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import wtc.carbon.entity.Complaint;

import java.util.List;

@Mapper
public interface ComplaintMapper {

    List<Complaint> getAllComplaints();

    Complaint getComplaintById(Integer id);

    Integer saveComplaint(Complaint complaint);

    Integer updateComplaint(Complaint complaint);

    Integer deleteComplaint(Integer id);

    List<Complaint> searchComplaints(@Param("title") String title, @Param("status") String status);
}
