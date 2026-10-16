% Tutorial 10 - Question 6
% Employee promotion eligibility

% a) Facts: employee(Name, ExperienceYears, TrainingStatus, Rating)
employee(ravi, 6, completed, 5).
employee(priya, 3, completed, 4).
employee(kumar, 8, not_completed, 5).
employee(meena, 7, completed, 4).

% b) Promotion requires at least 5 years, completed training,
% and a rating of at least 4.
promotion_eligible(Name) :-
    employee(Name, Years, completed, Rating),
    Years >= 5,
    Rating >= 4.

% c) Query:
% ?- promotion_eligible(Name).
% Expected results:
% Name = ravi ;
% Name = meena.
