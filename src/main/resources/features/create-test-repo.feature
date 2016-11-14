#Feature:	Create RDF Test Repository
#	As a user I want to ensure that I can create repositories on the RDF Server
#	Base RDF server  should contain the repository "SYSTEM" 
#Scenario:	Check System Repository Exists in RDF base server
#	Given I have the RepositoryAccessService setup
#	When I call createRepository with id "TEST" and "Test Repo"
#	Then there should be alteast 2 repositories and the one of them should be "TEST"
