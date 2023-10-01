using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.AI;

public class Semana9_10_CapsuleController : MonoBehaviour
{
    private NavMeshAgent agent;

    private Transform pickup;

    private void Start() {
        agent = GetComponent<NavMeshAgent>();
    }

    public void SetTarget(Transform pickup)
    {
        this.pickup = pickup;
    }
    
    public Transform GetTarget()
    {
        return pickup;
    }

    public void SetDestination(Transform target)
    {
        agent.SetDestination(target.position);
    }

    public float GetRemainingDistance()
    {
        return agent.remainingDistance;
    }
}
