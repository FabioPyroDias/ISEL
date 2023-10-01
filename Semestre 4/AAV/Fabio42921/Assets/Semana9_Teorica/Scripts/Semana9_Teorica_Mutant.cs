using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.AI;

public class Semana9_Teorica_Mutant : MonoBehaviour
{
    [SerializeField] private Transform[] waypoints;
    
    private Transform currentWaypoint;
    private int currentWaypointIndex;

    private NavMeshAgent agent;
    private Animator animator;
    private Transform player;

    void Start()
    {
        agent = GetComponent<NavMeshAgent>();
        animator = GetComponent<Animator>();
        player = GameObject.FindGameObjectWithTag("Player").transform;

        currentWaypointIndex = -1;
    }

    // Update is called once per frame
    void Update()
    {
        if(currentWaypoint != null)
        {
            animator.SetFloat("distanceToWaypoint", Vector3.Distance(transform.position, currentWaypoint.position));
        }
    
        HandleSight();
    }

    private void HandleSight()
    {
        Vector3 direction = player.position - transform.position;

        animator.SetFloat("angleToPlayer", Vector3.Angle(direction, transform.forward));
        animator.SetFloat("distanceToPlayer", direction.magnitude);

        RaycastHit hit;
        bool hasHit = Physics.Raycast(transform.position + Vector3.up, direction, out hit);
        
        if(hasHit)
        {
            animator.SetBool("hasHitPlayer", hit.transform.tag == "Player");
        }
        else
        {
            animator.SetBool("hasHitPlayer", false);
        }
    }

    private void SetNextWaypoint()
    {
        currentWaypointIndex = ++currentWaypointIndex % waypoints.Length;
        currentWaypoint = waypoints[currentWaypointIndex];
    
        agent.SetDestination(currentWaypoint.position);
    }

    private void UnStopAgent()
    {
        agent.isStopped = false;
    }

    private void StopAgent()
    {
        agent.isStopped = true;
    }

    private void OnAnimatorMove() 
    {
        agent.speed = (animator.deltaPosition / Time.deltaTime).magnitude;
    }

    public void OnStartPatrol()
    {
        SetNextWaypoint();
    }

    public void OnStartChase()
    {
        UnStopAgent();
    }

    public void OnStartAttack()
    {
        StopAgent();
    }

    public void HitPlayer()
    {
        if(animator.GetFloat("distanceToPlayer") < 2)
        {
            Destroy(player.gameObject);
        }
    }
}
