package com.example.pethospital.service;

import com.example.pethospital.pojo.Archive;

import java.util.List;

public interface ArchiveService {
    void addArchive(Archive archive);

    List<Archive> selectAllArchive();

    int selectArchiveCount();

    void deleteArchiveById(int archiveId);

    void updateArchive(Archive archive);

    List<Archive> getArchivesByName(String archiveName);

    Archive getArchiveById(int archiveId);
}
