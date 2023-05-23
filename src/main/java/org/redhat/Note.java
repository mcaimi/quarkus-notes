package org.redhat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.QueryHint;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "notes")
@NamedQuery(name = "Notes.AllNotes", query = "SELECT n FROM Note n ORDER BY n.id", hints = @QueryHint(name = "org.hibernate.cacheable", value = "false"))
public class Note {
    @Id
    @Column(unique = true)
    @SequenceGenerator(name = "noteSeq", sequenceName = "notes_id_sequential", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="noteSeq")
    private Long id;

    @Column(unique = false)
    private String contents;

    @Column(unique = false)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String newContent) {
        this.contents = newContent;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }
}

