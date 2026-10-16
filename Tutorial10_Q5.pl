% Tutorial 10 - Question 5
% Eligibility for advanced programming course

% a) Logical facts
python_pass(arun).
data_structures_pass(arun).

python_pass(bala).
data_structures_fail(bala).

python_pass(charan).
data_structures_pass(charan).

python_fail(divya).
data_structures_pass(divya).

% b) A student must pass both subjects
eligible(Student) :-
    python_pass(Student),
    data_structures_pass(Student).

% c) Query:
% ?- eligible(Student).
% Expected results:
% Student = arun ;
% Student = charan.
