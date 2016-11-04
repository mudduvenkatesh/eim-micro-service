#Feature:	RDF Starter Server
#	As a user I want to ensure that when RDF server is started I can access the server
#	Base RDF server  should contain the repository "SYSTEM" 
#Scenario:	Check System Repository Exists in RDF base server
#	Given I have the RepositoryAccessService
#	When I call getRepositories 
#	Then there should be 1 repository and the name of the repository should be "SYSTEM"