package DBDV.DB_projectBE.service;

import DBDV.DB_projectBE.dto.IsSuccessDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommunityService {
    @Autowired
    private CommunityRepository communityRepository;

    public IsSuccessDto writePost(PostDto postDto){
        IsSuccessDto isSuccessDto;
        try{
            String userId =
        }
    }
}
