package wtc.carbon.service.impl;// ComplaintServiceImpl.java
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import wtc.carbon.entity.Complaint;
import wtc.carbon.mapper.ComplaintMapper;
import wtc.carbon.service.ComplaintService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Resource
    private ComplaintMapper complaintMapper;

    @Override
    public List<Complaint> getAllComplaints() {
        return complaintMapper.getAllComplaints();
    }

    @Override
    public Complaint getComplaintById(Integer id) {
        return complaintMapper.getComplaintById(id);
    }

    @Override
    public boolean saveComplaint(Complaint complaint) {
        complaint.setCreatedTime(LocalDateTime.now());
        complaint.setStatus("待解决");
        return complaintMapper.saveComplaint(complaint) >= 1;
    }

    @Override
    public boolean updateComplaint(Complaint complaint) {
        return complaintMapper.updateComplaint(complaint) >= 1;
    }

    @Override
    public boolean deleteComplaint(Integer id) {
        return complaintMapper.deleteComplaint(id) >= 1;
    }

    @Override
    public List<Complaint> searchComplaints(String title, String status) {
        return complaintMapper.searchComplaints(title, status);
    }
}
