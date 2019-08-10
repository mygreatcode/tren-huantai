package com.tren.huantai.service.impl;

import com.tren.huantai.model.dto.HouseinfoDTO;
import com.tren.huantai.model.entity.NewHouseinfoEntity;
import com.tren.huantai.repository.base.HouseInfoRepository;
import com.tren.huantai.service.base.HouseInfoService;
import javassist.NotFoundException;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//C:\Users\Administrator\.gradle\caches\modules-2\files-2.1\org.webjars\jquery\3.4.1\f9cd2ff7f2da4c3f6839e9d5e5e92b0bbe1cbfb\jquery-3.4.1.jar!\META-INF\resources\webjars\jquery\3.4.1\jquery.js
@Slf4j
@Service
public class HouseInfoServiceimpl implements HouseInfoService {
    @Autowired(required=true)
    private HouseInfoRepository houseInfoRepository;




    @Override
    public List<HouseinfoDTO> searchinfobyxiaoqu(String str) {
        return null;
    }

    /**
     * search house info by str
     * @param str search input
     * @param citycode city
     * @return
     */
    @Cacheable(cacheNames = "houseinfo",key = "#str+#citycode")
    @Override
    public @NonNull List<HouseinfoDTO> searchinfo(String str,String citycode) {

        List<NewHouseinfoEntity> searchinfo = houseInfoRepository.searchinfo(str,citycode);
        return searchinfo.stream().map(houseinfoEntity -> (HouseinfoDTO)new HouseinfoDTO().convertFrom(houseinfoEntity)).collect(Collectors.toList());
    }

    @Override
    public @NonNull NewHouseinfoEntity removeHouseinfo(@NonNull Integer id) {
        return null;
    }

    @Override
    public @NonNull HouseinfoDTO convertToDto(@NonNull NewHouseinfoEntity newHouseinfoEntity) {
        return null;
    }

    /**
     * find all house info by paging
     * @param page
     * @param size
     * @param citycode
     * @return
     */
    @Transactional
    @Cacheable(cacheNames = "houseinfo",key = "#page")
    @Override
    public @NonNull Page<NewHouseinfoEntity> findallbypage(int page, int size, String citycode) {
       // Sort sort = new Sort(Sort.Direction.ASC, "id");//排序规则   多条件
        Pageable pageable =  PageRequest.of(page-1, size);
        NewHouseinfoEntity newHouseinfoEntity =new NewHouseinfoEntity();
        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withIgnorePaths("id").withIgnorePaths("price");
       Example<NewHouseinfoEntity> example=Example.of(newHouseinfoEntity,exampleMatcher);
         Page<NewHouseinfoEntity> all = houseInfoRepository.findAll(example,pageable);
        return all;
    }

    /**
     * find recomment house info
     * @param citycode
     * @return
     */
    @Transactional
    @Cacheable(cacheNames = "houseinfo",key = "#root.targetClass+#citycode")
    @Override
    public @NonNull List<HouseinfoDTO> findrecommenthouseinfo(String citycode) {
        Assert.notNull(citycode,"citycode must be not null");
        List<NewHouseinfoEntity> all = houseInfoRepository.findAllRecomment(citycode);
        return all.stream().map(HouseinfoEntity -> (HouseinfoDTO)new HouseinfoDTO().convertFrom(HouseinfoEntity)).collect(Collectors.toList());
    }


    @Override
    public List<NewHouseinfoEntity> listAll() {
        return null;
    }

    @Override
    public List<NewHouseinfoEntity> listAll(Sort sort) {
        return null;
    }

    @Override
    public Page<NewHouseinfoEntity> listAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<NewHouseinfoEntity> listAllByIds(Collection<Integer> integers) {
        return null;
    }

    @Override
    public List<NewHouseinfoEntity> listAllByIds(Collection<Integer> integers, Sort sort) {
        return null;
    }

    @Override
    public Optional<NewHouseinfoEntity> fetchById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public NewHouseinfoEntity getById(Integer integer) throws NotFoundException {
        return null;
    }

    @Override
    public NewHouseinfoEntity getByIdOfNullable(Integer integer) {
        return null;
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public void mustExistById(Integer integer) {

    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public NewHouseinfoEntity create(NewHouseinfoEntity newHouseinfoEntity) {
        return null;
    }

    @Override
    public List<NewHouseinfoEntity> createInBatch(Collection<NewHouseinfoEntity> houseinfoEntities) {
        return null;
    }

    @Override
    public NewHouseinfoEntity update(NewHouseinfoEntity newHouseinfoEntity) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public List<NewHouseinfoEntity> updateInBatch(Collection<NewHouseinfoEntity> houseinfoEntities) {
        return null;
    }

    @Override
    public NewHouseinfoEntity removeById(Integer integer) throws NotFoundException {
        return null;
    }

    @Override
    public NewHouseinfoEntity removeByIdOfNullable(Integer integer) {
        return null;
    }

    @Override
    public void remove(NewHouseinfoEntity newHouseinfoEntity) {

    }

    @Override
    public void removeInBatch(Collection<Integer> integers) {

    }

    @Override
    public void removeAll(Collection<NewHouseinfoEntity> houseinfoEntities) {

    }

    @Override
    public void removeAll() {

    }
}
