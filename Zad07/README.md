AS  -  ROBMS
<br><br>

    Datasource<br>
	 ^<br>    
	/|\<br>
	 |<br>
 	 |<br>
_______________________<br>
|persistance.xml      |<br>
|Encje + EntityManager|	DAO<br>
-----------------------<br>
-------------<br>
|Enterprise |		BL<br>
-------------<br><br>

			Transaction<br>
-----------------------------------<br><br>
----------<br>
|Jax - rs|<br>
----------<br>
   ^<br>
  /|\<br>
   |<br>
   |	HTTP<br>
   |<br>
  \|/<br>
   v<br>
---------<br>
|POSTMAN|<br>
---------<br>
<br><br>
<ul>
<li>@Entity</li>
<li>@Id</li>
<li>@GeneratedValue</li>
<li>@ManyToOne(fetchType, cascade)</li>
<li>OneToMany(--||--||--)</li>
<li>@ManyToMany(--||--||--)</li>
</ul>
<br><br>
fetchType LAZY ------> EAGER
	   ^
	   |_______LazyInitializationException

