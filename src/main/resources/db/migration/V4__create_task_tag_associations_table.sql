CREATE TABLE task_tag_associations (
    task_id INT REFERENCES tasks(task_id) ON DELETE CASCADE,
    tag_id INT REFERENCES task_tags(tag_id) ON DELETE CASCADE,
    PRIMARY KEY (task_id, tag_id)
);