package com.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.entities.FeedBack;

public interface IFeedBackRepository extends JpaRepository<FeedBack, Integer>{

}
