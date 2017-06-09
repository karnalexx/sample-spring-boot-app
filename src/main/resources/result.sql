SELECT a.name AS Article_Name, count(al.*) AS Count_Official_Text, count(al1.*) AS Count_English_Text
FROM articles a
LEFT JOIN article_link al ON a.id = al.article1_id AND al.article2_id IN (SELECT a.id FROM articles a WHERE a.type_id = 4)
LEFT JOIN article_link al1 ON a.id = al1.article1_id AND al1.article2_id IN (SELECT a.id FROM articles a WHERE a.type_id = 5)
GROUP BY a.type_id, a.name HAVING a.type_id = 1
ORDER BY a.name;