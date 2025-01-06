package wtc.carbon.service;// ComplaintService.java
import wtc.carbon.entity.Complaint;

import java.util.List;

public interface ComplaintService {

    List<Complaint> getAllComplaints();

    Complaint getComplaintById(Integer id);

    boolean saveComplaint(Complaint complaint);

    boolean updateComplaint(Complaint complaint);

    boolean deleteComplaint(Integer id);

    List<Complaint> searchComplaints(String title, String status);
}
